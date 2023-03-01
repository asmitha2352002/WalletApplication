package com.walletApplication.WalletApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class WalletServiceImpl implements WalletService{
    @Autowired
    private WalletJpaRepository jpaRepository;
    @Autowired
    private WalletRepository walletRepository;

    @Override
    public WalletDto registerWallet(WalletDto wallet) throws WalletException {
        return this.jpaRepository.save(wallet);
    }
    @Override
    public WalletDto getWalletById(Integer Id) throws WalletException {
        Optional<WalletDto> WalletOptional = this.jpaRepository.findById(Id);
        if(WalletOptional.isEmpty())
            throw new WalletException("Employee could not be found id:"+Id);

        return WalletOptional.get();
    }

    @Override
    public WalletDto updateWallet(WalletDto wallet) throws WalletException{
        Optional<WalletDto> employeeOptional = this.jpaRepository.findById(wallet.getId());
        if(employeeOptional.isEmpty())
            throw new WalletException("Employee could not be updated, not found id:"+wallet.getId());
        return this.jpaRepository.save(wallet);
    }

    @Override
    public WalletDto deleteWalletById(Integer employeeId) throws WalletException {
        Optional<WalletDto> employeeOptional = this.jpaRepository.findById(employeeId);
        if(employeeOptional.isEmpty())
            throw new WalletException("Employee could not be Deleted, not found id:"+employeeId);
        WalletDto foundEmployee = employeeOptional.get();
        this.jpaRepository.delete(foundEmployee);
        return foundEmployee;
    }

    @Override
    public List<WalletDto> getAllWallets() {
        return this.jpaRepository.findAll();
    }


    /**  @Override
    public WalletDto getWalletById(Integer walletId) throws WalletException {

    WalletDto wallet = this.jpaRepository.findWalletById(walletId);
    if(wallet==null)
    throw new WalletException("Wallet id does not exists:"+walletId);
    return wallet;
    }

     @Override
     public WalletDto updateWallet(WalletDto wallet) throws WalletException {
     return this.jpaRepository.updateWallet(wallet);
     }

     @Override
     public WalletDto deleteWalletById(Integer walletId) throws WalletException {
     return this.jpaRepository.deleteWalletById(walletId);
     }


     @Override
     public Double addFundsToWalletById(Integer walletId, Double amount) throws WalletException {
     WalletDto wallet = this.jpaRepository.getWalletById(walletId);
     if(wallet==null)
     throw new WalletException("Wallet does not exists to add funds, id:"+walletId);
     Double newBalance = wallet.getBalance()+amount;
     wallet.setBalance(newBalance);
     this.walletRepository.updateWallet(wallet);
     return newBalance;
     }

     @Override
     public Double withdrawFundsFromWalletById(Integer walletById, Double amount) throws WalletException {
     WalletDto wallet = this.walletRepository.getWalletById(walletById);
     if(wallet==null)
     throw new WalletException("Wallet does not exists to withdraw, try using valid account id");
     Double balance= wallet.getBalance();
     if(balance<amount)
     throw new WalletException("Insufficient balance, current balance:"+balance);
     balance-=amount;
     wallet.setBalance(balance);
     this.walletRepository.updateWallet(wallet);
     return balance;
     }

     @Override
     public Boolean fundTransfer(Integer fromWalletId, Integer toWalletId, Double amount) throws WalletException {

     WalletDto fromWallet = this.walletRepository.getWalletById(fromWalletId);
     if(fromWallet == null)
     throw new WalletException("From wallet does not exists, id:"+fromWalletId);
     WalletDto toWallet = this.walletRepository.getWalletById(toWalletId);
     if(toWallet== null)
     throw new WalletException("To wallet does not exists, id:"+toWalletId);
     Double fromBalance = fromWallet.getBalance();
     if(fromBalance<amount)
     throw new WalletException("Insufficient balance, current balance:"+fromBalance);

     fromWallet.setBalance(fromBalance-amount);

     Double toBalance = toWallet.getBalance();
     toWallet.setBalance(toBalance+amount);

     this.walletRepository.updateWallet(fromWallet);
     this.walletRepository.updateWallet(toWallet);
     return true;
     }

     @Override
     public Collection<WalletDto> getAllWallets() {
     return this.walletRepository.getAllWallets();
     }**/
}
