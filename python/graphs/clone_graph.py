class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

    def __repr__(self) -> str:
        return str(self.val) + "@ " + str(id(self)) + ": " + str(self.neighbors)

def clone_graph(node: 'Node') -> 'Node':
    
    cloned_refs = {}
    def cloner(nd: 'Node', ref):
        neighbors = []
        for n in nd.neighbors:
            if n in cloned_refs:
                neighbors.append(cloned_refs[n])
            else:
                ref = Node(n.val)
                cloned_refs[n] = ref
                ref = cloner(n, ref)
                neighbors.append(ref)
        ref.neighbors = neighbors
        return ref
    
    ref = Node(node.val)
    cloned_refs[node] = ref
    ref = cloner(node, ref)
    return ref


one = Node(1)
two = Node(2)
three = Node(3)
four = Node(4)

one_neighbors = [two, four]
two_neighbors = [one, three]
three_neighbors = [two, four]
four_neighbors = [one, three]

one.neighbors = one_neighbors
two.neighbors = two_neighbors
three.neighbors = three_neighbors
four.neighbors = four_neighbors


print("Before:")
print(one)
print()


cloned = clone_graph(one)

print("After:")
print(cloned)
###-------

# this one worked:
def cloneGraph(self, node: 'Node') -> 'Node':
    
    cloned_refs = {}
    
    def cloner(n):
        if n is None:
            return None
        
        if n in cloned_refs:
            return cloned_refs[n]
        
        copy = Node(n.val)
        cloned_refs[n] = copy
        ns = []
        for nn in n.neighbors:
            if nn in cloned_refs:
                ns.append(cloned_refs[nn])
            else:
                cloned = cloner(nn)
                ns.append(cloned)
        
        copy.neighbors = ns
        return copy
    
    return cloner(node)
        
        