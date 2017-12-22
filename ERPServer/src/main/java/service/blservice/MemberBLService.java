package service.blservice;

import objects.ResultMessage;
import vo.MemberVO;

import java.rmi.RemoteException;

/**
 * Created by py on 2017/10/20.
 * 管理员工信息的类
 */
public interface MemberBLService {
    /**
     * 增加员工信息
     * @param vo
     * @return
     */
    public ResultMessage add(MemberVO vo) throws RemoteException;

    /**
     * 删除员工信息
     * @param vo
     * @return
     */
    public ResultMessage delete(MemberVO vo) throws RemoteException;

    /**
     * 更新员工信息
     * @param vo
     * @return
     */
    public ResultMessage update(MemberVO vo) throws RemoteException;


}
