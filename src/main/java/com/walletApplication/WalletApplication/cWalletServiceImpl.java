package com.walletApplication.WalletApplication;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class cWalletServiceImpl implements WalletService{

    @Autowired
    private cWalletRepository WRepository;

    @Override
    public WalletDto registerWallet(WalletDto wallet) {
        return WRepository.addWallet(wallet);
    }

    @Override
    public WalletDto getWalletById(Integer Id)throws WalletException {
        WalletDto foundEmployee = WRepository.getWallet(Id);
        if(foundEmployee == null)
            throw new WalletException("Employee Id does not exists.");

        return foundEmployee;
    }

    @Override
    public WalletDto updateWallet(WalletDto wallet) {
        return WRepository.updateWallet(wallet);
    }

    @Override
    public WalletDto deleteWalletById(Integer Id)throws WalletException {
        WalletDto foundEmployee = WRepository.getWallet(Id);
        if(foundEmployee==null)
            throw new WalletException("Employee coud't be deleted, Id not found:"+Id);
        return WRepository.deleteWallet(Id);
    }

    @Override
    public List<WalletDto> getAllWallets() {
        return null;
    }
}


