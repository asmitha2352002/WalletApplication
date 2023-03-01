package com.walletApplication.WalletApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping("/")
    public String greet(){
        return "Hello welcome to wallet app.";
    }

    @PostMapping("wallet")
    public WalletDto registerWallet(@RequestBody WalletDto wallet) throws WalletException {
        return this.walletService.registerWallet(wallet);
    }

    @GetMapping("wallet/{id}")
    public WalletDto getWalletById(@PathVariable("id") Integer walletId) throws WalletException {
        return this.walletService.getWalletById(walletId);
    }
    @PutMapping("wallet")
    public WalletDto updateWallet(@RequestBody WalletDto wallet) throws WalletException {
        return this.walletService.updateWallet(wallet);
    }
    @DeleteMapping("wallet/{id}")
    public WalletDto deleteWallet(@PathVariable("id") Integer walletId) throws WalletException {
        return this.walletService.deleteWalletById(walletId);
    }
    /**
     @PatchMapping("wallet/{id}/{amount}")
     public Double addFundsToWalletById(@PathVariable("id")Integer walletId,@PathVariable("amount") Double amount) throws WalletException {
     return this.walletService.addFundsToWalletById(walletId,amount);
     }
     @PatchMapping("wallet/{id}/fund/{amount}")
     public Double withdrawFundsfromWalletById(@PathVariable("id")Integer walletId,@PathVariable("amount") Double amount) throws WalletException {
     return this.walletService.withdrawFundsFromWalletById(walletId,amount);
     }

     @PostMapping("wallet/fund")
     public Boolean fundTransfer(@RequestBody WalletTransferDto walletTransferDto) throws WalletException {
     return this.walletService.fundTransfer(walletTransferDto.getFromId(),walletTransferDto.getToId(),walletTransferDto.getAmount());
     }
     @GetMapping("wallets")
     public Collection<WalletDto> getAllWallets(){
     return this.walletService.getAllWallets();
     }**/
    @Autowired
    private WalletJpaRepository jpaRepository;
    @GetMapping("wallet/id/{id}")
    public List<WalletDto> getAllWalletHavingIdLike(@PathVariable("id") Integer id){
        return this.jpaRepository.findWalletById(id);
    }
    @GetMapping("Wallet/contain/{id}")
    public List<WalletDto> getAllEmployeesContainingId(@PathVariable("id") Integer id){
        return this.jpaRepository.findByIdContaining(id);
    }

    @GetMapping("Wallet/balance/{minBalance}/{maxBalance}")
    public List<WalletDto> findAllWalletsHavingBalanceBetween(@PathVariable("minBalance") Double minBalance,
                                                              @PathVariable("maxBalance")Double maxBalance){
        return this.jpaRepository.findWalletbalanceOrderByIdAsc(minBalance,maxBalance);

    }

    @GetMapping("custom/Wallet")
    public List<WalletDto> findAllEmployees(){
        return this.jpaRepository.getAllWallets();
    }

    @GetMapping("custom/Wallet/{id}")
    public List<WalletDto> findAllEmployeesHavingId(@PathVariable("id") Integer Id){
        return this.jpaRepository.getAllWalletHavingIdLike(Id);
    }

}
