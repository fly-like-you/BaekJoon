def solution(genres, plays):
    answer = []
    genre_total_play = {}
    genre_play = {}
    for i, (play, genre) in enumerate(zip(plays, genres)):
        genre_total_play.setdefault(genre, 0)
        genre_total_play[genre] += play

        genre_play.setdefault(genre, [])
        genre_play[genre].append((play, i))

    li1 = sorted(genre_total_play.items(), key=lambda x:x[1], reverse=True)
    for genre, total_play in li1:
        li2 = sorted(genre_play[genre], key=lambda x:(-x[0], x[1]))[:2]
        for tup in li2:
            answer.append(tup[1])
    return answer