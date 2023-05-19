package org.example;

import java.util.HashMap;

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

        



    }
}