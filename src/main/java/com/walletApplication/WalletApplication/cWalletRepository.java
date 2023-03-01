package com.walletApplication.WalletApplication;

public interface cWalletRepository {
    WalletDto addWallet(WalletDto wallet);
    WalletDto getWallet(Integer id);
    WalletDto updateWallet(WalletDto wallet);
    WalletDto deleteWallet(Integer eId);

}
