package com.sist.last.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sist.last.cmn.DTO;
import com.sist.last.cmn.SearchReview;
import com.sist.last.vo.Review;
import com.sist.last.vo.ReviewStar;
import com.sist.last.vo.Star;

@Repository
public class ReviewDaoImpl {

	final static Logger LOG = LoggerFactory.getLogger(ReviewDaoImpl.class);
	
	final String NAMESPACE = "com.sist.last.review";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public ReviewDaoImpl() {

	}

	public List<?> reviewStarList(DTO dto) throws SQLException {		

		SearchReview param = (SearchReview) dto;
		
		//mybatis sql: NAMESPACE+.+id;
		String statement = this.NAMESPACE+".reviewStarList";                                
		
		LOG.debug("========================");
		LOG.debug("param: " + param);
		LOG.debug("statement: " + statement);
		LOG.debug("========================");
		
		List<ReviewStar> list = sqlSessionTemplate.selectList(statement, param);
		
		for (ReviewStar vo : list) {
			LOG.debug(vo.toString());
		}

		return list;
	}
	
	
	public List<?> doRetrieve(DTO dto) throws SQLException {		

		SearchReview param = (SearchReview) dto;
		
		//mybatis sql: NAMESPACE+.+id;
		String statement = this.NAMESPACE+".doRetrieve";                                
		
		LOG.debug("========================");
		LOG.debug("param: " + param);
		LOG.debug("statement: " + statement);
		LOG.debug("========================");
		
		List<Review> list = sqlSessionTemplate.selectList(statement, param);
		
		for (Review vo : list) {
			LOG.debug(vo.toString());
		}
				
		return list;
	}
	
	public List<?> doRetrieveMy(DTO dto) throws SQLException {		

		SearchReview param = (SearchReview) dto;
		
		//mybatis sql: NAMESPACE+.+id;
		String statement = this.NAMESPACE+".doRetrieveMy";                                
		
		LOG.debug("========================");
		LOG.debug("param: " + param);
		LOG.debug("statement: " + statement);
		LOG.debug("========================");
		
		List<Review> list = sqlSessionTemplate.selectList(statement, param);
		
		for (Review vo : list) {
			LOG.debug(vo.toString());
		}
				
		return list;
	}
	
	public DTO doSelectOne(DTO dto) throws SQLException {
		Review inVO = (Review) dto;
		Review outVO = null;
		
		//mybatis sql: NAMESPACE+.+id;
		String statement = this.NAMESPACE+".doSelectOne";
		
		LOG.debug("========================");
		LOG.debug("review: " + inVO);
		LOG.debug("statement: " + statement);
		LOG.debug("========================");
		
		outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		
		LOG.debug("========================");
		LOG.debug("outVO: " + outVO);
		LOG.debug("========================");
		
		// data가 없을 경우 예외 발생
		if (null == outVO) {
			throw new EmptyResultDataAccessException(1);
		}
				
		return outVO;
	}
	
	public int doUpdate(DTO dto) throws SQLException {
		int flag = 0;
		Review review = (Review) dto;  
		
		//mybatis sql: NAMESPACE+.+id;
		String statement = this.NAMESPACE+".doUpdate";
		
		LOG.debug("========================");
		LOG.debug("user: " + review);
		LOG.debug("statement: " + statement);
		LOG.debug("========================");
		
		flag = this.sqlSessionTemplate.update(statement, review);
			
		return flag;
		
	}
	
	public int doDelete(DTO dto) throws SQLException {
		int flag = 0;
		Review review = (Review) dto;  
		
		//mybatis sql: NAMESPACE+.+id;
		String statement = this.NAMESPACE+".doDelete";
		
		LOG.debug("========================");
		LOG.debug("user: " + review);
		LOG.debug("statement: " + statement);
		LOG.debug("========================");
		
		flag = this.sqlSessionTemplate.insert(statement, review);
		
		return flag;
	}

	public int doInsert(DTO dto) throws SQLException {
		int flag = 0;
		Review review = (Review) dto;
		
		//mybatis sql: NAMESPACE+.+id;
		String statement = this.NAMESPACE+".doInsert";
		
		LOG.debug("========================");
		LOG.debug("user: " + review);
		LOG.debug("statement: " + statement);
		LOG.debug("========================");
		
		flag = this.sqlSessionTemplate.insert(statement, review);
		
		return flag;

	}

}
