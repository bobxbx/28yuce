package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.BntUser;
import com.ruoyi.system.domain.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户与角色关联表 数据层
 * 
 * @author ruoyi
 */
public interface BntUserMapper
{   /**
 * 插入一条用户记录
 * @param bntUser 用户对象
 * @return 插入的记录数
 */
int insertBntUser(BntUser bntUser);

    /**
     * 查询用户列表
     * @param bntUser 查询条件
     * @return 符合条件的用户列表
     */
    List<BntUser> selectBntUserList(BntUser bntUser);

    /**
     * 根据用户ID查询单个用户
     * @param id 用户ID
     * @return 用户对象
     */
    BntUser selectBntUserById(Long id);

    /**
     * 更新用户信息
     * @param bntUser 更新的用户对象
     * @return 更新的记录数
     */
    int updateBntUser(BntUser bntUser);

    /**
     * 根据用户ID删除用户
     * @param id 用户ID
     * @return 删除的记录数
     */
    int deleteBntUserById(Long id);

    /**
     * 批量删除用户
     * @param ids 用户ID列表
     * @return 删除的记录数
     */
    int deleteBntUsersByIds(@Param("ids") List<Long> ids);
}
