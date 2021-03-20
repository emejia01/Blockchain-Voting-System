import java.security.NoSuchAlgorithmException;

public class Blockchain {

    // Create a Genesis Block which will be the first Block in the chain
    Block GenesisBlock = new Block("0000000000", "");
    Block currentBlock = GenesisBlock;

    // Default Constructor
    public Blockchain() throws NoSuchAlgorithmException {
    }

    // Method to add a new block to the chain
    public void addBlock(String blockData) throws NoSuchAlgorithmException {
        Block newBlock = new Block(currentBlock.getCurrentHash(), blockData);
        currentBlock.setNextBlock(newBlock);
        currentBlock = currentBlock.getNextBlock();
    }

    // TODO add toString method to print out the contents of all the Blocks in the Chain
}
