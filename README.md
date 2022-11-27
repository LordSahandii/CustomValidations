# CustomValidations
[![](https://jitpack.io/v/LordSahandii/CustomValidations.svg)](https://jitpack.io/#LordSahandii/CustomValidations)

## What is it?

CustomValidation is a library designed for passioned developers to make their lives easier.

It lets developers to validate phone numbers, most of social medias such as instagram, snapchat, discord and etc. based on the Regexes.

It lets developers to throw a custom exception with their own desired message and they can even make a toast out of it and display it to users.

It also contains some exceptions such as network not found and user not found.

## Installation

- First you need to add maven url inside the settings.gradle file.
```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
- Then inside the project gradle.build add the maven url.
```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
- Finally, add the dependency inside the module gradle file.
```
dependencies {
  implementation 'com.github.LordSahandii:CustomValidations:Tag'
}
```
For more information about installations visit the [jitpack website](https://jitpack.io/#LordSahandii/CustomValidations)

## How To Use

=> To use this addon, just import it in the header of your file.

=> If you want to check validations for a phone-number or social medias get the instance first.
```
    val validationService = ValidationService.getInstance()
```
   then you can choose the type of validation you want.
```
 try {
      validationService.[yourTypeOfValidation]
  }catch (e: Error.ValidationException){
      e.makeToast(context = context)
  }
```
=> If you want to make your own exception you can import the Error from the library and throw a custom exception
```
throw Error.ValidationException("Your Message to the user")
```

=> You can use other features it have and we will be updating more features soon :))

## Jitpack Link

https://jitpack.io/#LordSahandii/CustomValidations

## Developers
- Lorenz Castillo
- Sahand Hajiseyedi
- Sukhmandeep Singh
- Kelsey Zirk

## License

MIT

Free Open Source Library

