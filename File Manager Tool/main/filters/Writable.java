package oop.ex6.filescript.filters;

import java.io.File;

public class Writable extends PermissionFilters{

	/**
	 * A data constructor.
	 * @param permissionValue - The permission value (YES/NO).
	 * @throws PermissionException - If the permission value is not valid.
	 */
	public Writable(String permissionValue) throws PermissionException {
		super(permissionValue);
	}

	@Override
	public boolean isPass(File file) {
		return (file.canWrite() == this.permissionValue);
	}
}
