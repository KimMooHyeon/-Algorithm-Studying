class Node(object):
    def __init__(self, value, next=None, before=None):
        self.before = before
        self.value = value
        self.next = next


class BrowserHistory(object):

    def __init__(self, homepage):
        self.head = Node(homepage)
        self.tail = Node(homepage)
        self.focus = Node(homepage)
        """
        :type homepage: str
        """

    def visit(self, url):
        """
        :type url: str
        :rtype: None
        """
        current = self.focus
        current.next = Node(url, before=current)
        self.focus = current.next
        self.tail = current.next

        return None

    def back(self, steps):
        """
        :type steps: int
        :rtype: str
        """
        currentNode = self.focus
        for i in range(0, steps):
            if currentNode.before is None:
                break
            currentNode = currentNode.before
        self.focus = currentNode
        return currentNode.value

    def forward(self, steps):
        """
        :type steps: int
        :rtype: str
        """
        currentNode = self.focus
        for i in range(0, steps):
            if currentNode.next is None:
                break
            currentNode = currentNode.next
        self.focus = currentNode
        return currentNode.value

# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory(homepage)
# obj.visit(url)
# param_2 = obj.back(steps)
# param_3 = obj.forward(steps)
