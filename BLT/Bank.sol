// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract BankAccount {

    mapping(address => uint256) private  balances;

    constructor() {
        balances[msg.sender] = 100; 
    }

    
    function deposit(uint amount) public {
        balances[msg.sender] += amount;
    }

    
    function withdraw(uint amount) public {
        require(balances[msg.sender] >= amount, "Not enough balance");
        balances[msg.sender] -= amount;
    }

    
    function getBalance() public view returns (uint256) {
        return balances[msg.sender];
    }
}
