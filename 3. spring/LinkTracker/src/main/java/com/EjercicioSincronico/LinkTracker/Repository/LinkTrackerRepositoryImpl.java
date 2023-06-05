package com.EjercicioSincronico.LinkTracker.Repository;

import com.EjercicioSincronico.LinkTracker.Entities.Link;
import com.EjercicioSincronico.LinkTracker.Exceptions.KeyAlreadyExistException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Random;

@Repository
public class LinkTrackerRepositoryImpl implements ILinkTrackerRepository {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
    private static final int PASSWORD_LENGTH = 10;
    private HashMap<Integer, Link> dataLinks = new HashMap<>();
    @Override
    // Crear Link
    public Link insertLink(Link l){
        Integer randomId = randomId();
        if (dataLinks.containsKey(l.getId())){
            throw new KeyAlreadyExistException();
        }
        // Creacion
        l.setId(randomId);
        l.setPassword(generateRandomPassword());
        dataLinks.put(l.getId(), l);
        return l;
    }

    @Override
    // Obtener Link
    public Link getLinkbyId(int id){
        return dataLinks.get(id);
    }

    @Override
    // Inhabilitar Link
    public void updateStatus(int linkId, boolean newStatus){
        Link link = dataLinks.get(linkId);
        if (link != null){
            link.setStatus(newStatus);
            dataLinks.put(linkId, link);
        }
    }

    @Override
    // Actualizar Metricas
    public void updateMetrics(int linkId){
        Link link = dataLinks.get(linkId);
        if (link != null){
            link.setRedirectionsCount(link.getRedirectionsCount() + 1);
            dataLinks.put(linkId, link);
        }
    }
    @Override
    // Obtener Metricas
    public int getMetricByLinkId(int linkId){
        return dataLinks.get(linkId).getRedirectionsCount();
    }


    private int randomId(){
        Random random = new Random();
        return random.nextInt(10) + 1;
    }

    private String generateRandomPassword(){
        Random random = new Random();
        StringBuilder password = new StringBuilder(PASSWORD_LENGTH);

        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(randomIndex));
        }

        return password.toString();
    }
}
