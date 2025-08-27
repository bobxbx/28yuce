package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.util.StringUtil;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.system.domain.BntUser;
import com.ruoyi.system.mapper.BntUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.mapper.SysNoticeMapper;
import com.ruoyi.system.service.ISysNoticeService;

/**
 * 公告 服务层实现
 * 
 * @author ruoyi
 */
@Service
public class SysNoticeServiceImpl implements ISysNoticeService
{
    @Autowired
    private SysNoticeMapper noticeMapper;
    @Autowired
    BntUserMapper userMapper;

    /**
     * 查询公告信息
     * 
     * @param noticeId 公告ID
     * @return 公告信息
     */
    @Override
    public SysNotice selectNoticeById(Long noticeId)
    {
        return noticeMapper.selectNoticeById(noticeId);
    }

    /**
     * 查询公告列表
     * 
     * @param notice 公告信息
     * @return 公告集合
     */
    @Override
    public List<SysNotice> selectNoticeList(SysNotice notice)
    {
        return noticeMapper.selectNoticeList(notice);
    }

    /**
     * 新增公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    @Override
    public int insertNotice(SysNotice notice)
    {
        if(StringUtil.isEmpty(notice.getFromUid())){
            BntUser bntUser=new BntUser();
            bntUser.setStatus(true);
            List<BntUser> userList = userMapper.selectBntUserList(null);
            StringJoiner joiner = new StringJoiner(",");
            for (BntUser user : userList) {
                joiner.add(user.getId()+"");  // 假设 BntUser 有一个 getName 方法
            }
            String result = joiner.toString();
            notice.setFromUid(result);
        }else {
            BntUser bntUser = userMapper.selectBntUserById(Long.valueOf(notice.getFromUid()));
            if(bntUser==null){
                throw new ServiceException("改用户id不存在");
            }
        }
        notice.setNoticeType("1");
        notice.setUserStatus("2");

        return noticeMapper.insertNotice(notice);
    }

    /**
     * 修改公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    @Override
    public int updateNotice(SysNotice notice)
    {
        return noticeMapper.updateNotice(notice);
    }

    /**
     * 删除公告对象
     * 
     * @param noticeId 公告ID
     * @return 结果
     */
    @Override
    public int deleteNoticeById(Long noticeId)
    {
        return noticeMapper.deleteNoticeById(noticeId);
    }

    /**
     * 批量删除公告信息
     * 
     * @param noticeIds 需要删除的公告ID
     * @return 结果
     */
    @Override
    public int deleteNoticeByIds(Long[] noticeIds)
    {
        return noticeMapper.deleteNoticeByIds(noticeIds);
    }
}
