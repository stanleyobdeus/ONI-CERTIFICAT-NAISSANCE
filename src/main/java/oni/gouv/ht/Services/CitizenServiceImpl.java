package oni.gouv.ht.Services;


import oni.gouv.ht.Bean.CitizenBean;
import oni.gouv.ht.Bean.CitizenByCriteriaBean;
import oni.gouv.ht.Models.Citizen;
import oni.gouv.ht.Models.Response;
import oni.gouv.ht.Utils.BuildHeaderRequestDermalog;
import oni.gouv.ht.Utils.Constant;
import oni.gouv.ht.Utils.VerifyIfPidIsValid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;

import oni.gouv.ht.Models.Error;

@Service
public class CitizenServiceImpl implements CitizenService {

    RestTemplate restTemplate = new RestTemplate();
    ModelMapper modelMapper;
    CitizenBean citizenBean;
    ResponseEntity<?> responseEntity = null;

    @Autowired
    BuildHeaderRequestDermalog buildHeaderRequestDermalog;

    @Autowired
    VerifyIfPidIsValid verifyIfPidIsValid;

    public static boolean isInteger(String s) {
        return isInteger(s, 10);
    }

    public static boolean isInteger(String s, int radix) {
        if (s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1) return false;
                else continue;
            }
            if (Character.digit(s.charAt(i), radix) < 0) return false;
        }
        return true;
    }

    @Override
    public Response getCitizenByPid(String pid) {

        if (!isInteger(pid))
            return new Response(null, new Error("Le PID ne peux pas avoir des Lettres..!", 400));
        if (pid.length() != 10)
            return new Response(null, new Error("Le PID Doit avoir 10 Chiffres..!", 400));

        HttpEntity<String> httpEntity = buildHeaderRequestDermalog.Build();

        try {
            responseEntity = restTemplate.exchange(Constant.URL_GET_CITOYEN + "/" + pid, HttpMethod.GET, httpEntity, Citizen.class);

        } catch (Exception e) {
            return new Response(null, new Error("Le Citoyen Avec Le PID "+pid+" Est Introuvalble",404));
        }

        modelMapper = new ModelMapper();
        citizenBean = modelMapper.map(responseEntity.getBody(), CitizenBean.class);
        return new Response(citizenBean, null);

    }

    @Override
    public Response getImageCitizenByPid(String pid) {
        if (!isInteger(pid))
            return new Response(null, new Error("Le PID ne peux pas avoir des Lettres..!", 400));
        if (pid.length() != 10)
            return new Response(null, new Error("Le PID Doit avoir 10 Chiffres..!", 400));

        HttpEntity<String> httpEntity = buildHeaderRequestDermalog.Build();

        try {
            responseEntity = restTemplate.exchange(Constant.URL_GET_CITOYEN_IMAGE + "/" + pid + "/Photo", HttpMethod.GET, httpEntity, byte[].class);
        } catch (Exception e) {
            return new Response(null, new Error("Le Citoyen Avec Le PID "+pid+" Est Introuvalble",404));
        }

        return new Response(responseEntity.getBody(), null);
    }

    @Override
    public Response getCitizenByCriteria(String GivenName, String Gender, String Surname, String DateOfBirth) {
        Map<String, String> param = new HashMap<>();
        if (GivenName != null && !GivenName.isBlank()) {
            param.put("GivenName", GivenName);
        }
        if (Gender != null && !Gender.isBlank()) {
            param.put("Gender", Gender);
        }
        if (Surname != null && !Surname.isBlank()) {
            param.put("Surname", Surname);
        }
        if (DateOfBirth != null && !DateOfBirth.isBlank()) {
            param.put("DateOfBirth", DateOfBirth);
        }
        String query = createQuery(param, Constant.URL_GET_CITOYEN);

        ResponseEntity<CitizenByCriteriaBean[]> responseEntit = null;
        List<CitizenByCriteriaBean> allCitizen;
        try {
            responseEntit = restTemplate.exchange(query, HttpMethod.GET, buildHeaderRequestDermalog.Build(), CitizenByCriteriaBean[].class);
            allCitizen = Arrays.asList(responseEntit.getBody());

        } catch (Exception e) {
          // System.out.println("erreur " + responseEntit.toString());
            return new Response(null, null);
        }
        return new Response(allCitizen, null);
    }

    private String createQuery(Map<String, String> param, String urlGetCitoyen) {
        StringBuilder resUrl = new StringBuilder(urlGetCitoyen);
        if (param == null || param.isEmpty()) {
            return resUrl.toString();
        }
        resUrl.append("?");
        Iterator<Map.Entry<String, String>> itr = param.entrySet().iterator();
        var entry = itr.next();
        resUrl.append(entry.getKey() + "=" + entry.getValue());
        while (itr.hasNext()) {
            resUrl.append("&");
            var values = itr.next();
            resUrl.append(values.getKey() + "=" + values.getValue());
        }
        return resUrl.toString();
    }


}
