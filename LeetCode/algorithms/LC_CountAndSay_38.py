class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        test = [('1',1)]
        out = test[0][0] + str(test[0][1])
        i=1
        while i<=n:
            test = []
            for j in range(0,len(out)):
                if len(test) is 0 or (test[len(test)-1][0] is not out[j]):
                    tup = (out[j],1)
                else:
                    tup = test.pop()
                    temp = tup[1]+1
                    tup = (tup[0],temp)
                test.append(tup)
            out = ''
            for iter in test:
                out += str(iter[1])+iter[0]
            i=i+1
        return '1' if n is 1 else out

print Solution().countAndSay(2)
