package wave21.Blog.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Blog {
    private String id;
    private String titulo;
    private String autorName;
    private String fechaPublicacion;
}
