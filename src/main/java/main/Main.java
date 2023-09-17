package main;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ProjectConfig;
import model.Comment;
import services.CommentService;
import space.jbpark.utility.MyUtil;

public class Main {
	private static Logger logger = MyUtil.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		var ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);
		var comment = new Comment();
		comment.setText("한국은행의 핵심기능은 물가안정이다.");
		comment.setAuthor("은행총재");
		var service = ctx.getBean("commentService", CommentService.class);
		service.editComment(comment);
		var result = service.publishComment(comment);
		logger.info("main: " + result);
		
	}

}
