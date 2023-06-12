package wave21.Blog.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import wave21.Blog.model.Blog;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class BlogRepository {
    private List<Blog> entradas;

    public BlogRepository() {
        this.entradas = initData();
    }

    public Blog findEntryById(String id){
        Blog entry = entradas.stream()
                .filter(s -> s.getId().equals(id))
                .findAny()
                .orElse(null);
        return entry;
    }

    public List<Blog> initData(){
        List<Blog> aRetornar =  new ArrayList<>();
        aRetornar.add(new Blog("1", "The Hobbit", "J.R.R. Tolkien", "2/2/1985"));
        aRetornar.add(new Blog("2", "1984", "George Orwell", "5/6/1948"));
        aRetornar.add(new Blog("3", "The Dark Tower", "Stephen King", "6/7/2005"));
        return aRetornar;
    }


}
