package br.com.luizalabs.wishlist.config;


import java.text.MessageFormat;


public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8823602357345693346L;

	public ObjectNotFoundException(String msg){
        super(msg.replaceAll("[{}]",""));
    }

    public ObjectNotFoundException(String msg, String[] args){

        super(MessageFormat.format(msg.replaceAll("[{}]", ""), args));

    }

    public ObjectNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
