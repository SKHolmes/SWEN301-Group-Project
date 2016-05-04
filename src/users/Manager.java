package users;

import java.util.Date;

/** User instance used to represent manager and associated permissions.
 *
 * @author Daniel Tait
 *
 */

public class Manager implements User {

	String userName;
	Date birthDate;

	public Manager(String name, Date birth){
		this.userName = name;
		this.birthDate = birth;
	}

	@Override
	public boolean permissionCheck(Action a) {
		if (a == Action.SEND_ITEM){return false;}
		else if (a == Action.CHARGE_CUSTOMER){return false;}
		else return true;
	}

	@Override
	public boolean editName(String name) {
		this.userName = name;
		return true;
	}

	@Override
	public void editBirth(Date d) {
		this.birthDate = d;
	}

}