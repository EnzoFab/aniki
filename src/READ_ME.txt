
Rajoutez les lignes suivantes dans logs/ConnectionLog ça permettra d'envoyer des mail via le compte
Je ne mets pas le mot de passes que je vous donnerai après

private final static String userNameGoogle = "yourbestfriend.aniki@gmail.com";
private final static String passwordGoogle = ""; //

    public static String getUserNameGoogle() {
        return userNameGoogle;
    }

    public static String getPasswordGoogle() {
        return passwordGoogle;
    }

Pour L'envoi de mail il faut aussi ajouter mail.jar et activation.jar au Classpath
file -> project structure -> librairies. et