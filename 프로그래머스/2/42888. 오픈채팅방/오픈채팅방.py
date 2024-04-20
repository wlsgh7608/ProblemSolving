def solution(record):
    
    nick_dict = {}
    
    for rec in record:
        t , *remains = rec.split()
        if t == "Enter" or t=="Change":
            u_id,nick = remains
            nick_dict[u_id] = nick
    result = []
    for rec in record:
        t,*remains = rec.split()
        
        if t=="Enter":
            k = remains[0]
            result.append(f"{nick_dict[k]}님이 들어왔습니다.")
        elif t =="Leave":
            k = remains[0]
            result.append(f"{nick_dict[k]}님이 나갔습니다.")
    
    return result