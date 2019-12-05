package com.stackroute.giphermanager.rabbitmq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface GipherBookmarkSource {
	
	
	@Output("bookmarkRetriveChannel")
	MessageChannel bookmarkRetrival();
	@Output("bookmarkDeletionChannel")
	MessageChannel bookmarkDeletion();

}
