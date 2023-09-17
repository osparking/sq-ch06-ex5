package services;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import aspect.ToLog;
import model.Comment;
import space.jbpark.utility.MyUtil;

@Service
public class CommentService {
	private Logger logger = MyUtil.getLogger(CommentService.class.getName());

	@ToLog
	public String publishComment(Comment comment) {
		logger.info("출판하는 코맨트 텍스트: " + comment.getText());
		return "성공함";
	}

	public void editComment(Comment comment) {
		logger.info("편집하는 코맨트: " + comment.getText());
	}
}
