package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String[]> smallCircuit = new HashMap<String, String[]>();
        String[] smallCircuitValues = {"4b464d9b-9681-4901-acde-41e5f483298c", "Circuito chico", "2 km por selva y arroyos"};

        Map<String, String[]> mediumCircuit = new HashMap<String, String[]>();
        String[] mediumCircuitValues = {"57eff725-fd9b-40f9-ae4e-bdddade37e68", "Circuito medio", "5 km por selva, arroyos y barro"};

        Map<String, String[]> advancedCircuit = new HashMap<String, String[]>();
        String[] advancedCircuitValues = {"c4a71e1d-d28b-42cf-8c1a-055b3594423d", "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra"};

        smallCircuit.put("4b464d9b-9681-4901-acde-41e5f483298c", smallCircuitValues);
        mediumCircuit.put("57eff725-fd9b-40f9-ae4e-bdddade37e68", mediumCircuitValues);
        advancedCircuit.put("c4a71e1d-d28b-42cf-8c1a-055b3594423d", advancedCircuitValues);

        Map<String, String[]> participant = new HashMap<String, String[]>();
        String[] participantValues = {"373a221a-58f3-46c6-acc3-4082017bd9ef", "leandro", "marcelo", "20", "997867697", "1234567890", "a"};
        participant.put("42c8fe76-9d39-49b2-bc2f-3ce292f04d10", participantValues);

        Map<String, String[]> registration = new HashMap<String, String[]>();
        String[] registrationValues = {"373a221a-58f3-46c6-acc3-4082017bd9ef", "373a221a-58f3-46c6-acc3-4082017bd9ef", "373a221a-58f3-46c6-acc3-4082017bd9ef", "1234567890"};
        registration.put("373a221a-58f3-46c6-acc3-4082017bd9ef", registrationValues);


    }
}