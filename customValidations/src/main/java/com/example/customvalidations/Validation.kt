package com.example.customvalidations

// https://stackoverflow.com/questions/16699007/regular-expression-to-match-standard-10-digit-phone-number
// https://stackoverflow.com/questions/39819830/what-are-the-allowed-character-in-snapchat-username
// https://regexr.com/3cg7r
// https://ihateregex.io/expr/discord-username/
// https://stackoverflow.com/questions/12018245/regular-expression-to-validate-username

/**
 * Constants Class - contains a Regex Class
 */
class Constants {
    /**
     * Regex Class - contains companion objects of different patterns such as phone number or username
     */
    class Regex {
        companion object {
            // Phone Number Regex Pattern
            val PHONE_NUMBER =
                Regex("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}\$")

            // Discord Username Regex Pattern
            val DISCORD_USERNAME = Regex("^.{3,32}#[0-9]{4}\$")

            // Instagram Username Regex Pattern with maximum 30 characters
            val INSTAGRAM_USERNAME =
                Regex("^(?!.*\\.\\.)(?!.*\\.\$)[^\\W][\\w.]{0,29}\$")

            // Snapchat Username Regex Pattern with maximum 15 characters
            val SNAPCHAT_USERNAME =
                Regex("^(?=\\S{3,15}\$)[a-zA-Z][a-zA-Z0-9]*(?:[_.-][a-zA-Z0-9]+)?\$")

            // User's Username Regex Pattern from 5 to 20 characters
            val USERNAME = Regex("^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$")
        }
    }
}

/**
 * ValidationService class - contains functions to validate
 */
class ValidationService {
    /**
     * isPhoneNumber - validates the phone number
     * @param data - The phone number given to the function
     */

    fun isPhoneNumber(data: String) {
        if (!Constants.Regex.PHONE_NUMBER.matches(data)) {
            throw Error.ValidationException("Phone Number Does Not Match")
        }
    }

    /**
     * isDiscordValid - validates the discord username
     * @param data - The discord username given to the function
     */
    fun isDiscordValid(data: String) {
        if (!Constants.Regex.DISCORD_USERNAME.matches(data)) {
            throw Error.ValidationException("Discord Username Does Not Match")
        }
    }

    /**
     * isUsernameValid - validates the username
     * @param data - The username given to the function
     */
    fun isUsernameValid(data: String) {
        if (!Constants.Regex.USERNAME.matches(data)) {
            throw Error.ValidationException("Username Does Not Match (It must be between 3-10)")
        }
    }

    /**
     * isInstagramValid - validates the Instagram Username
     * @param data - The instagram username given to the function
     */
    fun isInstagramValid(data: String) {
        if (!Constants.Regex.INSTAGRAM_USERNAME.matches(data)) {
            throw Error.ValidationException("Instagram Username Does Not Match")
        }
    }

    /**
     * isSnapchatValid - validates the snapchat username
     * @param data - The snapchat username given to the function
     */
    fun isSnapchatValid(data: String) {
        if (!Constants.Regex.SNAPCHAT_USERNAME.matches(data)) {
            throw Error.ValidationException("Snapchat Username Does Not Match")
        }
    }

    /**
     * Validate the length of a text message
     * @param
     */
    fun isMessageValid(text: String, minLength: Int = 3, maxLength: Int = 30) {
        if (minLength > text.length || maxLength < text.length) {
            throw Error.ValidationException("Message must be between $minLength and $maxLength characters")
        }
    }

    companion object {
        /**
         * Singleton for the class
         */
        private var INSTANCE: ValidationService? = null

        /**
         * Get instance for the game firestore repository
         */
        fun getInstance(): ValidationService {
            // Check if an instance already exists
            if (INSTANCE == null) {
                INSTANCE = ValidationService()
            }
            // return the instance
            return INSTANCE!!
        }

    }

}