package com.rozet.contract.wrappers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.StaticArray;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tuples.generated.Tuple7;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class RozetToken extends Contract {
    private static final String BINARY = "6000805460a060020a60ff021916905560c0604052600560808190527f526f7a657400000000000000000000000000000000000000000000000000000060a090815262000050916001919062000120565b506040805180820190915260038082527f524f5a00000000000000000000000000000000000000000000000000000000006020909201918252620000979160029162000120565b506003805460ff19166012179055348015620000b257600080fd5b506000805433600160a060020a031991821681178355670de0b6b3a7640000600d55678ac7230489e800006010556007805460018101825593527fa66cc928b5edb82af9bd49922954155ab7b0942694bea4ce44661d9a8736c68890920180549091169091179055620001c5565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200016357805160ff191683800117855562000193565b8280016001018555821562000193579182015b828111156200019357825182559160200191906001019062000176565b50620001a1929150620001a5565b5090565b620001c291905b80821115620001a15760008155600101620001ac565b90565b611c4080620001d56000396000f3006080604052600436106101cc5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166305d2035b81146101d157806306b11004146101fa57806306fdde0314610221578063095ea7b3146102ab5780630b7fea96146102cf57806318160ddd146102e4578063238dd893146102f957806323b872dd14610313578063313ce5671461033d578063318831451461036857806333b69c4c146103b9578063354d91de1461042a57806340c10f191461044b5780634259105c1461046f57806342966c681461049357806366188463146104ab5780637018fb84146104cf57806370a08231146104e45780637d618ae3146105055780637d64bcb41461055f578063850be2cc146105745780638da5cb5b1461059857806395d89b41146105c95780639ea224d7146105de578063a9059cbb146105f3578063b534bfd214610617578063b6f9bbb91461063b578063b77a2c1c14610650578063bca525b814610665578063cdd722531461067a578063cffedf071461068f578063d73dd623146106a4578063d8c41fdc146106c8578063da58c7d9146106e9578063dd62ed3e14610701578063efa8a33b14610728578063f7bb398414610786575b600080fd5b3480156101dd57600080fd5b506101e66107b0565b604080519115158252519081900360200190f35b34801561020657600080fd5b5061020f6107d1565b60408051918252519081900360200190f35b34801561022d57600080fd5b506102366107d7565b6040805160208082528351818301528351919283929083019185019080838360005b83811015610270578181015183820152602001610258565b50505050905090810190601f16801561029d5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156102b757600080fd5b506101e6600160a060020a0360043516602435610864565b3480156102db57600080fd5b5061020f6108ca565b3480156102f057600080fd5b5061020f6108d0565b34801561030557600080fd5b506103116004356108d6565b005b34801561031f57600080fd5b506101e6600160a060020a0360043581169060243516604435610c95565b34801561034957600080fd5b50610352610dfc565b6040805160ff9092168252519081900360200190f35b34801561037457600080fd5b50610380600435610e05565b60408051600160a060020a0396871681529490951660208501528385019290925260608301521515608082015290519081900360a00190f35b3480156103c557600080fd5b506103da600160a060020a0360043516610eb1565b60408051602080825283518183015283519192839290830191858101910280838360005b838110156104165781810151838201526020016103fe565b505050509050019250505060405180910390f35b34801561043657600080fd5b506101e6600160a060020a0360043516610f1d565b34801561045757600080fd5b506101e6600160a060020a0360043516602435610f32565b34801561047b57600080fd5b5061020f600160a060020a036004351660243561103b565b34801561049f57600080fd5b5061031160043561106b565b3480156104b757600080fd5b506101e6600160a060020a0360043516602435611149565b3480156104db57600080fd5b5061020f61123b565b3480156104f057600080fd5b5061020f600160a060020a0360043516611241565b34801561051157600080fd5b50610526600160a060020a036004351661125c565b6040518082610c8080838360005b8381101561054c578181015183820152602001610534565b5050505090500191505060405180910390f35b34801561056b57600080fd5b506101e66112b9565b34801561058057600080fd5b50610311600160a060020a036004351660243561135b565b3480156105a457600080fd5b506105ad6113c3565b60408051600160a060020a039092168252519081900360200190f35b3480156105d557600080fd5b506102366113d2565b3480156105ea57600080fd5b5061020f61142a565b3480156105ff57600080fd5b506101e6600160a060020a0360043516602435611430565b34801561062357600080fd5b506105ad600160a060020a0360043516602435611501565b34801561064757600080fd5b5061020f61152c565b34801561065c57600080fd5b5061020f611532565b34801561067157600080fd5b5061020f611539565b34801561068657600080fd5b506103da61153f565b34801561069b57600080fd5b5061020f6115a1565b3480156106b057600080fd5b506101e6600160a060020a03600435166024356115a6565b3480156106d457600080fd5b5061020f600160a060020a036004351661163f565b3480156106f557600080fd5b506105ad600435611651565b34801561070d57600080fd5b5061020f600160a060020a0360043581169060243516611679565b34801561073457600080fd5b506107406004356116a4565b60408051600160a060020a0398891681529690971660208701528587019490945260608501929092521515608084015260a083015260c082015290519081900360e00190f35b34801561079257600080fd5b50610311600160a060020a0360043516602435604435606435611701565b60005474010000000000000000000000000000000000000000900460ff1681565b600c5481565b60018054604080516020600284861615610100026000190190941693909304601f8101849004840282018401909252818152929183018282801561085c5780601f106108315761010080835404028352916020019161085c565b820191906000526020600020905b81548152906001019060200180831161083f57829003601f168201915b505050505081565b336000818152600660209081526040808320600160a060020a038716808552908352818420869055815186815291519394909390927f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925928290030190a350600192915050565b600d5481565b60045490565b6108de611b82565b6000806011848154811015156108f057fe5b60009182526020918290206040805160e08101825260079093029091018054600160a060020a0390811680855260018301549091169484019490945260028101549183019190915260038101546060830152600481015460ff1615156080830152600581015460a08301526006015460c0820152935033146109f957604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152602260248201527f4f6e6c7920746865207374616b6520686f6c6465722063616e2072656c65617360448201527f652e000000000000000000000000000000000000000000000000000000000000606482015290519081900360840190fd5b60608301516203f480014211610a0e57600080fd5b608083015115610a1d57600080fd5b600160808401526011805484919086908110610a3557fe5b60009182526020808320845160079390930201805473ffffffffffffffffffffffffffffffffffffffff19908116600160a060020a0394851617825585830151600183018054909216908516179055604080860151600283015560608601516003830155608086015160048301805460ff191691151591909117905560a0860151600583015560c09095015160069091015586840151878201519092168352600a905291902054610ae591611b18565b602080850151600160a060020a03166000908152600a82526040808220939093558286015130825260059092529190912054610b269163ffffffff611b1816565b3060009081526005602052604080822092909255848201518551600160a060020a0316825291902054610b5e9163ffffffff611b2a16565b8351600160a060020a0390811660009081526005602090815260409182902093909355855181870151825190815291519216923092600080516020611bf58339815191529281900390910190a360008360a00151118015610bc3575060008360c00151115b15610c8f57604083015160a0840151610be19163ffffffff611b4016565b600b54909250610bf7908363ffffffff611b1816565b600b556040830151600c54610c119163ffffffff611b1816565b600c819055600b54610c289163ffffffff611b6b16565b600d55604083015160c0840151610c449163ffffffff611b4016565b600e54909150610c5a908263ffffffff611b1816565b600e556040830151600f54610c749163ffffffff611b1816565b600f819055600e54610c8b9163ffffffff611b6b16565b6010555b50505050565b6000600160a060020a0383161515610cac57600080fd5b600160a060020a038416600090815260056020526040902054821115610cd157600080fd5b600160a060020a0384166000908152600660209081526040808320338452909152902054821115610d0157600080fd5b600160a060020a038416600090815260056020526040902054610d2a908363ffffffff611b1816565b600160a060020a038086166000908152600560205260408082209390935590851681522054610d5f908363ffffffff611b2a16565b600160a060020a038085166000908152600560209081526040808320949094559187168152600682528281203382529091522054610da3908363ffffffff611b1816565b600160a060020a0380861660008181526006602090815260408083203384528252918290209490945580518681529051928716939192600080516020611bf5833981519152929181900390910190a35060019392505050565b60035460ff1681565b6000806000806000610e15611b82565b6011805488908110610e2357fe5b60009182526020918290206040805160e08101825260079093029091018054600160a060020a0390811680855260018301549091169484018590526002820154928401839052600382015460608501819052600483015460ff16151560808601819052600584015460a087015260069093015460c0909501949094529b939a50909850909650945092505050565b600160a060020a038116600090815260096020908152604091829020805483518184028101840190945280845260609392830182828015610f1157602002820191906000526020600020905b815481526020019060010190808311610efd575b50505050509050919050565b60086020526000908152604090205460ff1681565b60008054600160a060020a03163314610f4a57600080fd5b60005474010000000000000000000000000000000000000000900460ff1615610f7257600080fd5b600454610f85908363ffffffff611b2a16565b600455600160a060020a038316600090815260056020526040902054610fb1908363ffffffff611b2a16565b600160a060020a038416600081815260056020908152604091829020939093558051858152905191927f0f6798a560793a54c3bcfe86a93cde1e73087d944c0ea20544137d412139688592918290030190a2604080518381529051600160a060020a03851691600091600080516020611bf58339815191529181900360200190a350600192915050565b60096020528160005260406000208181548110151561105657fe5b90600052602060002001600091509150505481565b3360009081526005602052604081205482111561108757600080fd5b50336000818152600560205260409020546110a8908363ffffffff611b1816565b600160a060020a0382166000908152600560205260409020556004546110d4908363ffffffff611b1816565b600455604080518381529051600160a060020a038316917fcc16f5dbb4873280815c1ee09dbd06736cffcc184412cf7a71a0fdb75d397ca5919081900360200190a2604080518381529051600091600160a060020a03841691600080516020611bf58339815191529181900360200190a35050565b336000908152600660209081526040808320600160a060020a03861684529091528120548083111561119e57336000908152600660209081526040808320600160a060020a03881684529091528120556111d3565b6111ae818463ffffffff611b1816565b336000908152600660209081526040808320600160a060020a03891684529091529020555b336000818152600660209081526040808320600160a060020a0389168085529083529281902054815190815290519293927f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925929181900390910190a3600191505b5092915050565b600b5481565b600160a060020a031660009081526005602052604090205490565b611264611bd4565b600160a060020a038216600090815260126020526040908190208151610c808101928390529160649082845b8154600160a060020a031681526001909101906020018083116112905750505050509050919050565b60008054600160a060020a031633146112d157600080fd5b60005474010000000000000000000000000000000000000000900460ff16156112f957600080fd5b6000805474ff00000000000000000000000000000000000000001916740100000000000000000000000000000000000000001781556040517fae5184fba832cb2b1f702aca6117b8d265eaf03ad33eb133f19dde0f5920fa089190a150600190565b60648110801561136c575060008110155b151561137757600080fd5b3360009081526012602052604090208290826064811061139357fe5b01805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03929092169190911790555050565b600054600160a060020a031681565b6002805460408051602060018416156101000260001901909316849004601f8101849004840282018401909252818152929183018282801561085c5780601f106108315761010080835404028352916020019161085c565b600e5481565b6000600160a060020a038316151561144757600080fd5b3360009081526005602052604090205482111561146357600080fd5b33600090815260056020526040902054611483908363ffffffff611b1816565b3360009081526005602052604080822092909255600160a060020a038516815220546114b5908363ffffffff611b2a16565b600160a060020a038416600081815260056020908152604091829020939093558051858152905191923392600080516020611bf58339815191529281900390910190a350600192915050565b6012602052600082815260409020816064811061151a57fe5b0154600160a060020a03169150829050565b60105481565b6203f48081565b600f5481565b6060600780548060200260200160405190810160405280929190818152602001828054801561159757602002820191906000526020600020905b8154600160a060020a03168152600190910190602001808311611579575b5050505050905090565b606481565b336000908152600660209081526040808320600160a060020a03861684529091528120546115da908363ffffffff611b2a16565b336000818152600660209081526040808320600160a060020a0389168085529083529281902085905580519485525191937f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925929081900390910190a350600192915050565b600a6020526000908152604090205481565b600780548290811061165f57fe5b600091825260209091200154600160a060020a0316905081565b600160a060020a03918216600090815260066020908152604080832093909416825291909152205490565b60118054829081106116b257fe5b60009182526020909120600790910201805460018201546002830154600384015460048501546005860154600690960154600160a060020a03958616975094909316949193909260ff16919087565b611709611b82565b600080851161171757600080fd5b600160a060020a038616151561172c57600080fd5b3360009081526005602052604090205485111561174857600080fd5b33600090815260056020526040902054611768908663ffffffff611b1816565b33600090815260056020526040808220929092553081522054611791908663ffffffff611b2a16565b30600081815260056020908152604091829020939093558051888152905191923392600080516020611bf58339815191529281900390910190a3338252600160a060020a038616602080840182905260408085018890526000928352600a909152902054611805908663ffffffff611b2a16565b600160a060020a038088166000908152600a602090815260408083209490945542606087019081526080870183815260a088018a815260c089018a815260118054600181810183559188528b51600782027f31ecc21a745e3968a04e9570e4425bc18fa8019c68028196b546d1669c200c6881018054928c1673ffffffffffffffffffffffffffffffffffffffff199384161790558d8901517f31ecc21a745e3968a04e9570e4425bc18fa8019c68028196b546d1669c200c698201805491909c169216919091179099558b8a01517f31ecc21a745e3968a04e9570e4425bc18fa8019c68028196b546d1669c200c6a8a015594517f31ecc21a745e3968a04e9570e4425bc18fa8019c68028196b546d1669c200c6b89015592517f31ecc21a745e3968a04e9570e4425bc18fa8019c68028196b546d1669c200c6c8801805491151560ff1990921691909117905590517f31ecc21a745e3968a04e9570e4425bc18fa8019c68028196b546d1669c200c6d870155517f31ecc21a745e3968a04e9570e4425bc18fa8019c68028196b546d1669c200c6e90950194909455338352600982529382208054938401815582528120909101829055909150841180156119cf5750600083115b15611b10573360009081526008602052604090205460ff161515611a55576007805460018181019092557fa66cc928b5edb82af9bd49922954155ab7b0942694bea4ce44661d9a8736c68801805473ffffffffffffffffffffffffffffffffffffffff1916339081179091556000908152600860205260409020805460ff191690911790555b611a7e611a6f836040015186611b4090919063ffffffff16565b600b549063ffffffff611b2a16565b600b556040820151600c54611a989163ffffffff611b2a16565b600c819055600b54611aaf9163ffffffff611b6b16565b600d556040820151611adb90611acc90859063ffffffff611b4016565b600e549063ffffffff611b2a16565b600e556040820151600f54611af59163ffffffff611b2a16565b600f819055600e54611b0c9163ffffffff611b6b16565b6010555b505050505050565b600082821115611b2457fe5b50900390565b600082820183811015611b3957fe5b9392505050565b600080831515611b535760009150611234565b50828202828482811515611b6357fe5b0414611b3957fe5b6000808284811515611b7957fe5b04949350505050565b60e0604051908101604052806000600160a060020a031681526020016000600160a060020a03168152602001600081526020016000815260200160001515815260200160008152602001600081525090565b610c806040519081016040528060649060208202803883395091929150505600ddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3efa165627a7a72305820df23aae4309e3b73320a47400647bf1c02664d2257d5385fb59915d3fc89aed30029";

    public static final String FUNC_MINTINGFINISHED = "mintingFinished";

    public static final String FUNC_TOTALBADGEPRICEVOTEAMOUNT = "totalBadgePriceVoteAmount";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_BADGEPRICE = "badgePrice";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_RELEASESTAKEDTOKENS = "releaseStakedTokens";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_DECIMALS = "decimals";

    public static final String FUNC_GETSTAKEBYID = "getStakeById";

    public static final String FUNC_STAKESOF = "stakesOf";

    public static final String FUNC_DIDVOTE = "didVote";

    public static final String FUNC_MINT = "mint";

    public static final String FUNC_STAKESOFUSER = "stakesOfUser";

    public static final String FUNC_BURN = "burn";

    public static final String FUNC_DECREASEAPPROVAL = "decreaseApproval";

    public static final String FUNC_TOTALBADGEPRICEVOTE = "totalBadgePriceVote";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_GETVOTESFORSUPERUSERS = "getVotesForSuperUsers";

    public static final String FUNC_FINISHMINTING = "finishMinting";

    public static final String FUNC_VOTEFORSUPERUSER = "voteForSuperUser";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TOTALSTAKEREQUIREMENTVOTE = "totalStakeRequirementVote";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_VOTESFORSUPERUSERS = "votesForSuperUsers";

    public static final String FUNC_STAKEREQUIREMENT = "stakeRequirement";

    public static final String FUNC_STAKETIME = "stakeTime";

    public static final String FUNC_TOTALSTAKEREQUIREMENTVOTEAMOUNT = "totalStakeRequirementVoteAmount";

    public static final String FUNC_GETVOTERS = "getVoters";

    public static final String FUNC_NUMBEROFVOTESFORSUPERUSERS = "numberOfVotesForSuperUsers";

    public static final String FUNC_INCREASEAPPROVAL = "increaseApproval";

    public static final String FUNC_AMOUNTSTAKEDFOR = "amountStakedFor";

    public static final String FUNC_VOTERS = "voters";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_ALLSTAKES = "allStakes";

    public static final String FUNC_STAKETOKENS = "stakeTokens";

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event BURN_EVENT = new Event("Burn", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event MINT_EVENT = new Event("Mint", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event MINTFINISHED_EVENT = new Event("MintFinished", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList());
    ;

    protected RozetToken(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected RozetToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<Boolean> mintingFinished() {
        final Function function = new Function(FUNC_MINTINGFINISHED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> totalBadgePriceVoteAmount() {
        final Function function = new Function(FUNC_TOTALBADGEPRICEVOTEAMOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> approve(String _spender, BigInteger _value) {
        final Function function = new Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_spender), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> badgePrice() {
        final Function function = new Function(FUNC_BADGEPRICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> totalSupply() {
        final Function function = new Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> releaseStakedTokens(BigInteger id) {
        final Function function = new Function(
                FUNC_RELEASESTAKEDTOKENS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(id)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferFrom(String _from, String _to, BigInteger _value) {
        final Function function = new Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_from), 
                new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> decimals() {
        final Function function = new Function(FUNC_DECIMALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple5<String, String, BigInteger, BigInteger, Boolean>> getStakeById(BigInteger id) {
        final Function function = new Function(FUNC_GETSTAKEBYID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}));
        return new RemoteCall<Tuple5<String, String, BigInteger, BigInteger, Boolean>>(
                new Callable<Tuple5<String, String, BigInteger, BigInteger, Boolean>>() {
                    @Override
                    public Tuple5<String, String, BigInteger, BigInteger, Boolean> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<String, String, BigInteger, BigInteger, Boolean>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (Boolean) results.get(4).getValue());
                    }
                });
    }

    public RemoteCall<List> stakesOf(String lender) {
        final Function function = new Function(FUNC_STAKESOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(lender)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<Boolean> didVote(String param0) {
        final Function function = new Function(FUNC_DIDVOTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> mint(String _to, BigInteger _amount) {
        final Function function = new Function(
                FUNC_MINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> stakesOfUser(String param0, BigInteger param1) {
        final Function function = new Function(FUNC_STAKESOFUSER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> burn(BigInteger _value) {
        final Function function = new Function(
                FUNC_BURN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> decreaseApproval(String _spender, BigInteger _subtractedValue) {
        final Function function = new Function(
                FUNC_DECREASEAPPROVAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_spender), 
                new org.web3j.abi.datatypes.generated.Uint256(_subtractedValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> totalBadgePriceVote() {
        final Function function = new Function(FUNC_TOTALBADGEPRICEVOTE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> balanceOf(String _owner) {
        final Function function = new Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<List> getVotesForSuperUsers(String user) {
        final Function function = new Function(FUNC_GETVOTESFORSUPERUSERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(user)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray<Address>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<TransactionReceipt> finishMinting() {
        final Function function = new Function(
                FUNC_FINISHMINTING, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> voteForSuperUser(String vote, BigInteger index) {
        final Function function = new Function(
                FUNC_VOTEFORSUPERUSER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(vote), 
                new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> symbol() {
        final Function function = new Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> totalStakeRequirementVote() {
        final Function function = new Function(FUNC_TOTALSTAKEREQUIREMENTVOTE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> transfer(String _to, BigInteger _value) {
        final Function function = new Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> votesForSuperUsers(String param0, BigInteger param1) {
        final Function function = new Function(FUNC_VOTESFORSUPERUSERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> stakeRequirement() {
        final Function function = new Function(FUNC_STAKEREQUIREMENT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> stakeTime() {
        final Function function = new Function(FUNC_STAKETIME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> totalStakeRequirementVoteAmount() {
        final Function function = new Function(FUNC_TOTALSTAKEREQUIREMENTVOTEAMOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<List> getVoters() {
        final Function function = new Function(FUNC_GETVOTERS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<BigInteger> numberOfVotesForSuperUsers() {
        final Function function = new Function(FUNC_NUMBEROFVOTESFORSUPERUSERS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> increaseApproval(String _spender, BigInteger _addedValue) {
        final Function function = new Function(
                FUNC_INCREASEAPPROVAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_spender), 
                new org.web3j.abi.datatypes.generated.Uint256(_addedValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> amountStakedFor(String param0) {
        final Function function = new Function(FUNC_AMOUNTSTAKEDFOR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> voters(BigInteger param0) {
        final Function function = new Function(FUNC_VOTERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> allowance(String _owner, String _spender) {
        final Function function = new Function(FUNC_ALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner), 
                new org.web3j.abi.datatypes.Address(_spender)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple7<String, String, BigInteger, BigInteger, Boolean, BigInteger, BigInteger>> allStakes(BigInteger param0) {
        final Function function = new Function(FUNC_ALLSTAKES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple7<String, String, BigInteger, BigInteger, Boolean, BigInteger, BigInteger>>(
                new Callable<Tuple7<String, String, BigInteger, BigInteger, Boolean, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple7<String, String, BigInteger, BigInteger, Boolean, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<String, String, BigInteger, BigInteger, Boolean, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (Boolean) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> stakeTokens(String _beneficiary, BigInteger amount, BigInteger badgeVote, BigInteger stakeVote) {
        final Function function = new Function(
                FUNC_STAKETOKENS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_beneficiary), 
                new org.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.web3j.abi.datatypes.generated.Uint256(badgeVote), 
                new org.web3j.abi.datatypes.generated.Uint256(stakeVote)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<RozetToken> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RozetToken.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<RozetToken> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RozetToken.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TransferEventResponse> transferEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<TransferEventResponse> transferEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventObservable(filter);
    }

    public List<BurnEventResponse> getBurnEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(BURN_EVENT, transactionReceipt);
        ArrayList<BurnEventResponse> responses = new ArrayList<BurnEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            BurnEventResponse typedResponse = new BurnEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.burner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<BurnEventResponse> burnEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, BurnEventResponse>() {
            @Override
            public BurnEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(BURN_EVENT, log);
                BurnEventResponse typedResponse = new BurnEventResponse();
                typedResponse.log = log;
                typedResponse.burner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<BurnEventResponse> burnEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(BURN_EVENT));
        return burnEventObservable(filter);
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ApprovalEventResponse> approvalEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVAL_EVENT, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<ApprovalEventResponse> approvalEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventObservable(filter);
    }

    public List<MintEventResponse> getMintEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(MINT_EVENT, transactionReceipt);
        ArrayList<MintEventResponse> responses = new ArrayList<MintEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MintEventResponse typedResponse = new MintEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.to = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MintEventResponse> mintEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, MintEventResponse>() {
            @Override
            public MintEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MINT_EVENT, log);
                MintEventResponse typedResponse = new MintEventResponse();
                typedResponse.log = log;
                typedResponse.to = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<MintEventResponse> mintEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MINT_EVENT));
        return mintEventObservable(filter);
    }

    public List<MintFinishedEventResponse> getMintFinishedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(MINTFINISHED_EVENT, transactionReceipt);
        ArrayList<MintFinishedEventResponse> responses = new ArrayList<MintFinishedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MintFinishedEventResponse typedResponse = new MintFinishedEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MintFinishedEventResponse> mintFinishedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, MintFinishedEventResponse>() {
            @Override
            public MintFinishedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MINTFINISHED_EVENT, log);
                MintFinishedEventResponse typedResponse = new MintFinishedEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public Observable<MintFinishedEventResponse> mintFinishedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MINTFINISHED_EVENT));
        return mintFinishedEventObservable(filter);
    }

    public static RozetToken load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RozetToken(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static RozetToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RozetToken(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class TransferEventResponse {
        public Log log;

        public String from;

        public String to;

        public BigInteger value;
    }

    public static class BurnEventResponse {
        public Log log;

        public String burner;

        public BigInteger value;
    }

    public static class ApprovalEventResponse {
        public Log log;

        public String owner;

        public String spender;

        public BigInteger value;
    }

    public static class MintEventResponse {
        public Log log;

        public String to;

        public BigInteger amount;
    }

    public static class MintFinishedEventResponse {
        public Log log;
    }
}
