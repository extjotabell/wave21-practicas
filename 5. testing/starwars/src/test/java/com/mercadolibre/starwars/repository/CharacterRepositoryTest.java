package repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterRepositoryTest {

    @Autowired
    CharacterRepository characterRepository;
    @Test
    public void findAllByNameOk(){
        String query = "C-3PO";
        List<CharacterDTO> expected = new ArrayList<>();

        CharacterDTO c3po = new CharacterDTO("C-3PO","NA", "gold", "yellow", "112BBY",
                "NA", "Tatooine", "Droid", 167, 75);

        expected.add(c3po);

        List<CharacterDTO> result = characterRepository.findAllByNameContains(query);

        assertEquals(expected,result);
    }
}
