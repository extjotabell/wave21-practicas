package wave21.Blog.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BlogDTO {
    private String titulo;
    private String autorName;
    private String fechaPublicacion;
}
