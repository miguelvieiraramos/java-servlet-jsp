package validation.validators;

import presentation.protocols.Validation;

public class UserValidation implements Validation {
	public boolean validate(String... args) {
		if(args[0].matches("^[a-zA-Z0-9]*$") && args[1].matches("^[a-zA-Z0-9 ]*$")) {
			return true;
		}
		return false;
	}
}
