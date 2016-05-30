package oop.ex6.filescript.filters;

public abstract class PermissionFilters implements Filter {

	/** The value for allowed permission */
	protected final String ALLOWED = "YES";
	/** The value for denied permission */
	protected final String DENIED = "NO";
	
	/** The permission value */ 
	protected boolean permissionValue;
	/**
	 * A data constructor.
	 * @param permissionValue - The permission value to check.
	 * @throws PermissionException - If the permission value is not valid.
	 */
	public PermissionFilters(String permissionValue)
			throws PermissionException {
		if (permissionValue.equals(ALLOWED)) {
			this.permissionValue = true;
		} else if (permissionValue.equals(DENIED)) {
			this.permissionValue = false;
		} else {
			throw new PermissionException();
		}
	}
}
