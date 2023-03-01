package com.walletApplication.WalletApplication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WalletJpaRepository extends JpaRepository<WalletDto, Integer> {
    List<WalletDto> findWalletById(Integer id);
    List<WalletDto> findByIdContaining(Integer id);
    List<WalletDto> findWalletbalanceOrderByIdAsc(Double minBalance,Double maxBalance);
    //   List<WalletDto> findWalletbyid(Integer id);

    @Query("SELECT Wallets FROM WalletDto wallet")
    List<WalletDto> getAllWallets();
    @Query("SELECT wallet FROM WalletDto wallet WHERE wallet.id LIKE :id")
    List<WalletDto>getAllWalletHavingIdLike(Integer Id);

}
