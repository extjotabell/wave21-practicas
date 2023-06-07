package com.example.be_java_hisp_w21_g02.repository;

import com.example.be_java_hisp_w21_g02.model.Post;
import com.example.be_java_hisp_w21_g02.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class UserRepositoryImpl implements IUserRepository{
    private HashMap<Integer, User> dataUser = new HashMap<>();
    private int POST_ID_COUNT = 1;

    public UserRepositoryImpl(List<User> dataUser) {
        loadInitialData();
        // comentario para probar PRS
    }

    public User getUser(int userIdToFollow){
        return  dataUser.get(userIdToFollow);
    }

    public void persistFollows(User persistedUser, User persistedFollowUser){
        dataUser.put(persistedUser.getId(), persistedUser);
        dataUser.put(persistedFollowUser.getId(), persistedFollowUser);
    }

    public List<User> getUsers(Set<Integer> users){
        List<User> result = new ArrayList<>();
        users.forEach( x->{
                    result.add(this.getUser(x));
                });
        return result;
    }


    @Override
    public void createPost(Post post) {
        post.setPostId(POST_ID_COUNT);
        POST_ID_COUNT++;
        dataUser.get(post.getUserId())
               .getPosts()
               .add(post);
    }

    /*
    * Se declara una lista de usuarios a retornar.
    * Se busca la lista de usuarios seguidos por userId.
    * Por cada uno de esos usuarios, se busca la lista de posts.
    * Se agregan los posts a un usuario temp, y se agrega el temp a la lista de usuarios a retornar.
     */
    @Override
    public List<User> listFollowingPosts2Weeks(int userId) {
        List<User> result = new ArrayList<>();
        dataUser.get(userId).getFollowing().forEach(followingId -> {
            User tempUser = new User();
            User tempFollowingUser = dataUser.get(followingId);
            tempUser.setId(tempFollowingUser.getId());
            tempUser.setUsername(tempFollowingUser.getUsername());
            tempUser.setFollowers(tempFollowingUser.getFollowers());
            tempUser.setFollowing(tempFollowingUser.getFollowing());

            List<Post> filteredList = tempFollowingUser.getPosts()
                    .stream()
                    .filter(post -> post.getDate().isAfter(LocalDate.now().minusWeeks(2).minusDays(1)))
                    .sorted(Comparator.comparing(Post::getDate).reversed()).toList();
            tempUser.setPosts(filteredList);
            result.add(tempUser);
        });

        return result;
    }

    @Override
    public long countPromoPost(int userId){
        List<Post> filteredPromoList = dataUser.get(userId).getPosts();
        return filteredPromoList.stream()
                .filter(Post::isHasPromo)
                .count();
    }

    private void loadInitialData() {

        User user1 = new User(1, "JavierRydel", new HashSet<>(), new HashSet<>(), new ArrayList<>());
        User user2 = new User(2, "GastonBarro", new HashSet<>(), new HashSet<>(), new ArrayList<>());
        User user3 = new User(3, "YaninaFaretta", new HashSet<>(), new HashSet<>(), new ArrayList<>());
        User user4 = new User(4, "AdrianRodriguez", new HashSet<>(), new HashSet<>(), new ArrayList<>());
        User user5 = new User(5, "JoseGonzaloez", new HashSet<>(), new HashSet<>(), new ArrayList<>());
        User user6 = new User(6, "FlagusRodriguez", new HashSet<>(), new HashSet<>(), new ArrayList<>());
        User user7 = new User(7, "LeandroMarcelo", new HashSet<>(), new HashSet<>(), new ArrayList<>());
        User user8 = new User(8, "GonzaloMarquez", new HashSet<>(), new HashSet<>(), new ArrayList<>());
        User user9 = new User(9, "MartinMarquez", new HashSet<>(), new HashSet<>(), new ArrayList<>());
        User user10 = new User(10, "GabrielaMonzon", new HashSet<>(), new HashSet<>(), new ArrayList<>());

        dataUser.put(user1.getId(), user1);
        dataUser.put(user2.getId(), user2);
        dataUser.put(user3.getId(), user3);
        dataUser.put(user4.getId(), user4);
        dataUser.put(user5.getId(), user5);
        dataUser.put(user6.getId(), user6);
        dataUser.put(user7.getId(), user7);
        dataUser.put(user8.getId(), user8);
        dataUser.put(user9.getId(), user9);
        dataUser.put(user10.getId(), user10);
    }

    
}
