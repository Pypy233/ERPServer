package rmi;

import objects.ResultMessage;
import service.blservice.ClassifyBLService;
import service.blservice.Impl.ClassifyBLServiceImpl;
import vo.ClassifyVO;
import vo.GoodsVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class DataRemoteObject extends UnicastRemoteObject implements ClassifyBLService{
    private static final long serialVersionUID = 4029039744279087114L;
    private ClassifyBLService classifyBLService;

    protected DataRemoteObject() throws RemoteException{
        classifyBLService = new ClassifyBLServiceImpl();
    }


    @Override
    public ResultMessage addClassify(ClassifyVO vo) throws RemoteException {
        return classifyBLService.addClassify(vo);
    }

    @Override
    public ResultMessage deleteClassify(ClassifyVO vo) throws RemoteException {
        return classifyBLService.deleteClassify(vo);
    }

    @Override
    public ResultMessage updateClassify(ClassifyVO vo) throws RemoteException {
        return classifyBLService.updateClassify(vo);
    }

    @Override
    public ArrayList<GoodsVO> getGoods(ClassifyVO vo) throws RemoteException {
        return classifyBLService.getGoods(vo);
    }
}
