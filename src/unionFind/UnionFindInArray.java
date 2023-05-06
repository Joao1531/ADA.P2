package unionFind;
/**
 * public class UnionFindInArray implements UnionFind {
 * <p>
 * static final long serialVersionUID = 0L;
 * <p>
 * <p>
 * // The partition is a forest implemented in an array.
 * protected int[] partition;
 * <p>
 * // Definition of the range of valid elements.
 * protected String validRangeMsg;
 * <p>
 * <p>
 * // Creates the partition {{0}, {1}, ..., {domainSize-1}}.
 * public UnionFindInArray( int domainSize ) {
 * partition = new int[domainSize];
 * for ( int i = 0; i < domainSize; i++ )
 * partition[i] = -1;
 * <p>
 * int lastElement = domainSize - 1;
 * validRangeMsg = "Range of valid elements: 0, 1, ..., " + lastElement;
 * }
 * <p>
 * <p>
 * protected boolean isInTheDomain( int number ) {
 * return ( number >= 0 ) && ( number < partition.length );
 * }
 * <p>
 * <p>
 * // Pre-condition: 0 <= element < partition.length.
 * protected boolean isRepresentative( int element ) {
 * return partition[element] < 0;
 * }
 * <p>
 * <p>
 * // Returns the representative of the set that contains
 * // the specified element.
 * //
 * // Without side effects - Recursive.
 * public int find( int element ) throws InvalidElementException {
 * if ( !this.isInTheDomain(element) )
 * throw new InvalidElementException(validRangeMsg);
 * <p>
 * return this.findRec(element);
 * }
 * <p>
 * <p>
 * // Pre-condition: 0 <= element < partition.length.
 * protected int findRec( int element ) {
 * if ( partition[element] < 0 )
 * return element;
 * <p>
 * return this.findRec( partition[element] );
 * }
 * <p>
 * <p>
 * // Returns the representative of the set that contains
 * // the specified element.
 * //
 * // Without side effects - Iterative.
 * public int find( int element ) throws InvalidElementException {
 * if ( !this.isInTheDomain(element) )
 * throw new InvalidElementException(validRangeMsg);
 * <p>
 * int node = element;
 * while ( partition[node] >= 0 )
 * node = partition[node];
 * return node;
 * }
 * <p>
 * <p>
 * // Returns the representative of the set that contains
 * // the specified element.
 * //
 * // With path compression.
 * public int find( int element ) throws InvalidElementException {
 * if ( !this.isInTheDomain(element) )
 * throw new InvalidElementException(validRangeMsg);
 * <p>
 * return this.findPathCompr(element);
 * }
 * <p>
 * <p>
 * // Pre-condition: 0 <= element < partition.length.
 * protected int findPathCompr( int element ) {
 * if ( partition[element] < 0 )
 * return element;
 * <p>
 * int root = this.findPathCompr( partition[element] );
 * partition[element] = root;
 * return root;
 * }
 * <p>
 * <p>
 * // Removes the two distinct sets S1 and S2 whose representatives are
 * // the specified elements, and inserts the set S1 U S2.
 * // The representative of the new set S1 U S2 can be any of its members.
 * //
 * // Union by size.
 * public void union( int rep1, int rep2 ) throws InvalidElementException,
 * NotRepresentativeException, EqualSetsException {
 * if ( !this.isInTheDomain(rep1) || !this.isInTheDomain(rep2) )
 * throw new InvalidElementException(validRangeMsg);
 * if ( !this.isRepresentative(rep1) )
 * throw new NotRepresentativeException("First argument");
 * if ( !this.isRepresentative(rep2) )
 * throw new NotRepresentativeException("Second argument");
 * if ( rep1 == rep2 )
 * throw new EqualSetsException("The two arguments are equal");
 * <p>
 * if ( partition[rep1] <= partition[rep2] ) {
 * // Size(S1) >= Size(S2).
 * partition[rep1] += partition[rep2];
 * partition[rep2] = rep1;
 * }
 * else {
 * // Size(S1) < Size(S2).
 * partition[rep2] += partition[rep1];
 * partition[rep1] = rep2;
 * }
 * }
 * <p>
 * <p>
 * // Removes the two distinct sets S1 and S2 whose representatives are
 * // the specified elements, and inserts the set S1 U S2.
 * // The representative of the new set S1 U S2 can be any of its members.
 * //
 * // Union by height or by rank.
 * public void union( int rep1, int rep2 ) throws InvalidElementException,
 * NotRepresentativeException, EqualSetsException {
 * if ( !this.isInTheDomain(rep1) || !this.isInTheDomain(rep2) )
 * throw new InvalidElementException(validRangeMsg);
 * if ( !this.isRepresentative(rep1) )
 * throw new NotRepresentativeException("First argument");
 * if ( !this.isRepresentative(rep2) )
 * throw new NotRepresentativeException("Second argument");
 * if ( rep1 == rep2 )
 * throw new EqualSetsException("The two arguments are equal");
 * <p>
 * if ( partition[rep1] <= partition[rep2] ) {
 * // Height(S1) >= Height(S2).
 * if ( partition[rep1] == partition[rep2] )
 * partition[rep1]--;
 * partition[rep2] = rep1;
 * }
 * else
 * // Height(S1) < Height(S2).
 * partition[rep1] = rep2;
 * }
 * }
 */
























