package rmi;

import service.blservice.ClassifyBLService;

import java.rmi.Remote;

public class RemoteHelper {
    private Remote remote;
    private static RemoteHelper remoteHelper = new RemoteHelper();
    public static RemoteHelper getInstance(){
        return remoteHelper;
    }

    private RemoteHelper() {

    }

    public void setRemote(Remote remote){
        this.remote = remote;
    }

    public ClassifyBLService getClassifyBLService(){
        return (ClassifyBLService)remote;
    }
}
