# influeHands - All Influencer in Our Hands
Particular attention brings us to the solution of easiness in planning social media marketing/campaign. As we mentioned above, social media users from Indonesia have dramatically increased. It implies a more promising Indonesian audience and the growth of influencers. Influencers have played a significant role in the success of social media marketing/campaigns. An unpopular brand/influencer to the most well-known brand/influencer will benefit each other owing to this idea. Though, any brand will discover a sort of influencer that is relevant to their criteria. Therefore, our team will develop a platform that aims to provide such a service.

## About Dataset
We use a dataset of influencers from Instagram and TikTok from [SocialBlade](https://socialblade.com/), We collect this dataset from the beginning by selecting one by one influencer that we will include in our dataset

## About Model

[![](https://raw.githubusercontent.com/fachrul-rh/influeHands-ML/main/Assets/content-based.png)](https://github.com/fachrul-rh/influeHands-ML)
<br>
<br>
This approach is used for methods that will retrieve useful information from the extracted items. This information must be ensured is good information and can be ascertained to be relevant to users. The process of extracting used items will increase the possibility of the emergence of new items that have never been seen before. Basically this method is very dependent on user behavior. The main assumption under the content-based approach is that items or documents can be identified by a set of features extracted directly from their content.<br>
As previously explained, **content-based recommendation** techniques are a special case of information-based techniques. In this way, users attempt to make predictions based on analysis of interrelated items or metadata. This technique allows us to find out all the items used by users in the past and can be used as a basis for determining how similar their preferences are to current items. For items that have a similarity to the old ranking pattern, it can be used to calculate the ranking of the new item.

## Deployment
We deploy our model using Flask
<br>
In this model we are working on generate .npy file from google collab
<br>

[![](https://raw.githubusercontent.com/fachrul-rh/influeHands-ML/main/Assets/ig.png)](https://github.com/fachrul-rh/influeHands-ML)
[![](https://raw.githubusercontent.com/fachrul-rh/influeHands-ML/main/Assets/tiktok.png)](https://github.com/fachrul-rh/influeHands-ML)
<br>
This file stores data that has been converted to numpy, to be run when there is a whishlist input from the user

### How to run our model recommendation system
- On folder Deployment select folder Instagram or Tiktok, install the requirements.txt
  ``` 
  pip install -r requirements.txt
  ```
- Run file main.py
  ```
  python main.py
  ```
On the terminal you will see Running on http://127.0.0.1:5000 <br>
<br>
- Open postman app to try running localhost <br><br>
[![](https://raw.githubusercontent.com/fachrul-rh/influeHands-ML/main/Assets/post.png)](https://github.com/fachrul-rh/influeHands-ML)<br>
- Create this input.json user for recommendation <br><br>
[![](https://raw.githubusercontent.com/fachrul-rh/influeHands-ML/main/Assets/input.png)](https://github.com/fachrul-rh/influeHands-ML)<br>
- This the result recommendation from user wish list <br><br>
[![](https://raw.githubusercontent.com/fachrul-rh/influeHands-ML/main/Assets/result.png)](https://github.com/fachrul-rh/influeHands-ML)
