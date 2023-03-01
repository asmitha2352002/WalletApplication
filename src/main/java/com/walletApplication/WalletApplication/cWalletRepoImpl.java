package com.walletApplication.WalletApplication;

import java.util.HashMap;
import java.util.Map;

public class cWalletRepoImpl implements cWalletRepository  {
    Map<Integer,WalletDto> walletDtoMap = new HashMap<>();

    @Override
    public WalletDto addWallet(WalletDto wallet) {
        walletDtoMap.put(wallet.getId(),wallet);
        return wallet;
    }

    @Override
    public WalletDto getWallet(Integer id) {
        return walletDtoMap.get(id);
    }

    @Override
    public WalletDto updateWallet(WalletDto walletDto) {
        return walletDtoMap.replace(walletDto.getId(), walletDto);
    }

    @Override
    public WalletDto deleteWallet(Integer Id) {
        return walletDtoMap.remove(Id);
    }

}
