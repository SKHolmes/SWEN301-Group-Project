package users;

import java.util.Date;

/** User instance used to represent store clerk and associated permissions.
 *
 * @author Daniel Tait
 *
 */

public class Clerk implements User {

	String userName;
	Date birthDate;

	public Clerk(String name, Date birth){
		this.userName = name;
		this.birthDate = birth;
	}

	@Override
	public boolean permissionCheck(Action a) {
		if (a == Action.SEND_ITEM){return true;}
		else if (a == Action.CHARGE_CUSTOMER){return true;}
		else return false;
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