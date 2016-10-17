package com.ingweb.prestamoequipos.bl;

import com.ingweb.prestamoequipos.model.User;

public interface IUserBL {

	public void signUp(User user);
	
	public void lostPassword(User user);
	
	public void changePassword(User user);
	
	public void login(User user);
}
