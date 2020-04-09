package com.dxyinme.demo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.dxyinme.demo.model.CommentExample;
import com.dxyinme.demo.mapper.CommentMapper;
import com.dxyinme.demo.model.Comment;
import com.dxyinme.demo.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public long countByExample(CommentExample example) {
        return commentMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(CommentExample example) {
        return commentMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer commentId) {
        return commentMapper.deleteByPrimaryKey(commentId);
    }

    @Override
    public int insert(Comment record) {
        return commentMapper.insert(record);
    }

    @Override
    public int insertSelective(Comment record) {
        return commentMapper.insertSelective(record);
    }

    @Override
    public List<Comment> selectByExample(CommentExample example) {
        return commentMapper.selectByExample(example);
    }

    @Override
    public Comment selectByPrimaryKey(Integer commentId) {
        return commentMapper.selectByPrimaryKey(commentId);
    }

    @Override
    public int updateByExampleSelective(Comment record, CommentExample example) {
        return commentMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Comment record, CommentExample example) {
        return commentMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Comment record) {
        return commentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Comment record) {
        return commentMapper.updateByPrimaryKey(record);
    }

}

