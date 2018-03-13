package com.niit.colloboration_backendDAO;

import java.util.ArrayList;
import java.util.List;

import com.niit.colloboration_backendModel.Friend;
import com.niit.colloboration_backendModel.User;

public interface FriendDAO {
	public boolean addFriend(Friend friend);
	public boolean delete(Friend friend );
	public boolean accept(int friendreqid);
	public boolean reject(int friendreqid);
	public List  < Friend >getfriendrequest(int friendreqid,int myid);
	public ArrayList<Friend> getAllFriendRequestsByUser(int user_id);
	public ArrayList<Friend> getAllFriend();
	public ArrayList<Friend> getAllMyFriend(int myid);
	public ArrayList<Friend> getAllpendingentries(int myid);
	public ArrayList<Friend> getAllPendingrequests( int user_id);
    public User getUserById(int user_id);
    public Friend acceptfriendrequest(Friend friend);
    public Friend rejectfriendrequest(Friend friend);
    public ArrayList<Friend> getAllMyFriendpend(int myid);
}

