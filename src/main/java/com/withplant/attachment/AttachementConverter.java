package com.withplant.attachment;

import lombok.SneakyThrows;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class AttachementConverter {


    public static class StringToAttahementConverter implements Converter<String, Set<Attachement>> {

        @SneakyThrows
        @Override
        public Set<Attachement> convert(String s) {
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(s);

            Set<Attachement> list = new HashSet<>();

            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject obj = (JSONObject) jsonArray.get(i);

                Attachement albumFile = new Attachement();
                System.out.println("!!!PATH " + obj.get("path"));
                albumFile.setPath((String) obj.get("path"));
                albumFile.setFileName((String) obj.get("fileName"));
                albumFile.setSaveName((String) obj.get("saveName"));

                list.add(albumFile);
            }

            return list;
        }
    }

}
