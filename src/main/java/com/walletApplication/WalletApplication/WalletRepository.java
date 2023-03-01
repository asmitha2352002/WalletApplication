package com.walletApplication.WalletApplication;

import java.util.Collection;

public interface WalletRepository {
    WalletDto createWallet(WalletDto newWallet);
    WalletDto getWalletById(Integer  walletId);
    WalletDto updateWallet(WalletDto wallet);
    WalletDto deleteWalletById(Integer walletId);
    Collection<WalletDto> getAllWallets();
}
