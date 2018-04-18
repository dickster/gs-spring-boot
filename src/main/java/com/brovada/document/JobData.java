package com.brovada.document;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JobData {

    private Map<String, Object> values;

    // common (typed) stuff here...  could use acord as a template for this but not explicitly.
    private String firstName;
    private String lastName;
    private Date effectiveDate;
    //  etc....
//    private Address address;
//    private Email email;
//    private PhoneNumber phone;


    public JobData(Map<String,Object> values) {
        this.values = values;
        convertAccordingToConfiguration();
    }

    public JobData() {
        this.values = new HashMap<String,Object>();
        convertAccordingToConfiguration();
    }

    private void convertAccordingToConfiguration() {

        // why not just use jackson straight up here?  will work if mappings line up.
        // for more complicated scenarios do this the long way.
        //   config = {useDefaultJackson:true}
        //
        // iterate mappings
        //  for (String key:mappings.keySet()) {
        //     String targetOgnl = mappings.get(key);     e.g.    name.first-->firstName
        //     Object oldValue = map.get(key);
        //     Class targetType = getTargetType(targetOgnl);
        //     convertedValue = convert(oldValue, targetType);
        //     BeanUtils.setValue(this, targetOgnl, convertedValue);
        //  }

    }


//    public void foo() {
//        ObjectMapper mapper = new ObjectMapper();
//        String json = "{\"name\":\"mkyong\", \"age\":29}";
//
//        Map<String, Object> map = new HashMap<String, Object>();
//
//        // convert JSON string to Map
//        try {
//            map = mapper.readValue(json, new TypeReference<Map<String, String>>(){});
//        }
//        catch (JsonGenerationException e) {
//            e.printStackTrace();
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}
