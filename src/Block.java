import java.security.NoSuchAlgorithmException;

public class Block {

    // Block data fields
    private String previousHash;
    private String data;
    private long nonce;
    private String currentHash;
    private Block nextBlock = null;

    static int DIFFICULTY = 2; // Leading zero's difficulty

    // Constructor MUST take the previous hash and the data for the current Block
    public Block(String previousHash, String data) throws NoSuchAlgorithmException {
        this.previousHash = previousHash;
        this.data = data;
        this.nonce = calculateNonce(DIFFICULTY);
        this.currentHash = calculateHash();
    }

    // Getter and Setter methods
    public String getCurrentHash() {
        return this.currentHash;
    }

    public void setNextBlock(Block nextBlock) {
        this.nextBlock = nextBlock;
    }
    public Block getNextBlock() {
        return this.nextBlock;
    }

    // Helper function to find the Nonce value
    public long calculateNonce(int difficulty) throws NoSuchAlgorithmException {
        String currentNonceValue;
        String hashInput;
        String currentHash;
        while (true) {
            // Calculate random Nonce and respective Hash value
            currentNonceValue = String.valueOf((int)(Math.random() * 10000000 + 0));
            hashInput = this.previousHash + this.data + currentNonceValue;
            currentHash = SHA256Helper.getHash(hashInput);

            // Check if calculated hash is valid
            String leadingZeros = "0".repeat(difficulty);
            if (currentHash.startsWith(leadingZeros)) {
                break;
            }
        }

        return Long.parseLong(currentNonceValue);
    }

    // Helper function to find the current Hash value
    public String calculateHash() throws NoSuchAlgorithmException {
        String hashInput = this.previousHash + this.data + this.nonce;
        return SHA256Helper.getHash(hashInput);
    }
}
