class Solution(object):
    def searchInsert(self,nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        return self.insertPosUtil(nums,0,len(nums)-1,target)

    def insertPosUtil(self,arr,start,end,target):
        if start==end:
            return start if target<=arr[start] else start+1
        mid = (start+end)/2
        if(arr[mid]==target):
            if(mid==0 or arr[mid-1]<target):
                return mid
            else:
                return self.insertPosUtil(arr,start,mid,target)
        elif(arr[mid]<target):
            return self.insertPosUtil(arr,mid+1,end,target)
        else:
            if mid-1<0 or arr[mid-1] < target:
                return mid
            return self.insertPosUtil(arr,start,mid-1,target)

nums = [1,1,1,1,1,1]
target = 1
print Solution().searchInsert(nums,target)