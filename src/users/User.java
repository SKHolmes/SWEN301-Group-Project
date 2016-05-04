package users;

import java.util.Date;

/** Defines a user within the system. Different implementations of User will allow for different permissions for certain actions
 *
 * @author Daniel Tait
 *
 */

public interface User {

	/** Checks against static boolean values in this instance of 'user' to determine if this user has clearance to perform
	 * the given action
	 *
	 * @param a - The action which needs permission
	 * @return True if this user has permission to perform action, false otherwise
	 */

	public boolean permissionCheck(Action a);

	/** Edits user name field from old value to parameter input.
	 * Add username rules later...
	 *
	 * @param n - new name String value
	 * @return true if successful edit false otherwise
	 */
	public boolean editName(String n);

	/** Edits birth date field from old value to parameter input. Will always accept if d is valid Date instance
	 *
	 * @param d - new date instance
	 */

	public void editBirth(Date d);
}
