package com.example.be_java_hisp_w21_g02.service;

import com.example.be_java_hisp_w21_g02.dto.response.FollowedListDTO;
import com.example.be_java_hisp_w21_g02.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w21_g02.dto.response.FollowersListDTO;
import com.example.be_java_hisp_w21_g02.repository.IUserRepository;
import org.springframework.http.ResponseEntity;

public interface IUsersService {
    /**
     * Add the user with id userId to the followers of the user with id userIdToFollow
     * @param userId the id of the user that wants to follow
     * @param userIdToFollow the id of the user that will be followed by the user
     */
    void followUser(int userId, int userIdToFollow);

    /**
     * Remove the user with id userIdToUnFollow from the followers of the user with id userId
     * @param userId the id of the user that wants to unfollow
     * @param userIdToUnFollow the id of the user that will be unfollowed by the user
     */
    void unFollowUser(int userId, int userIdToUnFollow);

    /**
     * @param userId the id of the user that wants to know the number of followers
     * @return A DTO with the number of followers of the user with id userId, it's name and id
     */
    FollowersCountDTO getFollowersCount(int userId);

    /**
     * @param userId the id of the user that wants to know the number of followers
     * @return A DTO with the username, id and a list of followers which contains the name and id of each follower
     */
    FollowersListDTO getFollowersList(int userId);

    /**
     * @param userId the id of the user that wants to know its list of followers
     * @param order parameter to order the list by name in ascending or descending order
     * @return A DTO with the username, id and a ordered by name list of followers  which contains the name and id of each follower
     */
    FollowersListDTO getFollowersList(int userId, String order);

    /**
     * @param userId the id of the user that wants to know its list of followed users
     * @return A DTO with the username, id and a list of followed users which contains the name and id of each followed user
     */
    FollowedListDTO getFollowedList(int userId);

    /**
     * @param userId the id of the user that wants to know its list of followed users
     * @param order parameter to order the list by name in ascending or descending order
     * @return A DTO with the username, id and a ordered by name list of followed users which contains the name and id of each followed user
     */
    FollowedListDTO getFollowedList(int userId, String order);

}
